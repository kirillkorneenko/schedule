package controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import servise.Servise;
import thread.Example;
import thread.Schedule;
import thread.Schedule_;
import thread.ThreadDemon;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@Controller
@SessionAttributes(value = "userEntity1")
public class ControllerMain {

    @ModelAttribute("userEntity1")
    public UserEntity create(){
        return new UserEntity();
    }

    @Autowired()
    @Qualifier("service")
    private Servise servise;

    public void setService(Servise servise) {
        this.servise = servise;
    }


    @PostConstruct
    public void init(){
        ThreadDemon threadDemon = new ThreadDemon(servise);
        threadDemon.start();
    }



    @RequestMapping(value = "entrance",method = RequestMethod.POST)
    public ModelAndView test(@ModelAttribute("userEntity1") UserEntity userEntity1,String user, @RequestParam String password,@RequestParam(required = false, value = "enter") String enter, @RequestParam(required = false, value = "registration") String registration, Model model)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (enter != null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setLogin(user);
            userEntity.setPassword(password);
            userEntity1 = servise.authorization(userEntity);

            if (userEntity1 == null) {
                modelAndView.setViewName("index");
                modelAndView.addObject("userEntity1", null);
                modelAndView.addObject("test", true);
            } else {

                boolean flag = false;
                modelAndView.addObject("userEntity1", userEntity1);
                List<SheduleEntity> sheduleEntities = servise.getListShedule();
                for(SheduleEntity sheduleEntity: sheduleEntities){
                    UserEntity userEntity2= sheduleEntity.getUserByCodeUserId();
                    if (sheduleEntity.getUserByCodeUserId().getId()== userEntity1.getId()){
                        modelAndView.setViewName("welcome");
                        modelAndView.addObject("flag", false);
                        flag = true;
                    }
                }
                if(!flag) {
                    modelAndView.setViewName("welcomeDown");
                    modelAndView.addObject("flag", true);
                }
            }
       } else if(registration != null)
        {
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }



        @RequestMapping(value = "registration", method = RequestMethod.POST )
            public ModelAndView registration(@RequestParam String login, @RequestParam String password,@RequestParam Integer numberGroup, @RequestParam String name, @RequestParam String surname, @RequestParam(required = false, value = "save") String save, @RequestParam(required = false, value = "cancel") String cancel, Model model ){
            ModelAndView modelAndView = new ModelAndView();
            if(save!=null){
                UserEntity userEntity = new UserEntity();
                userEntity.setLogin(login);
                userEntity.setPassword(password);
                userEntity.setGroupNumber(numberGroup);
                userEntity.setName(name);
                userEntity.setSurname(surname);
                userEntity.setStatus("user");
                servise.addUser(userEntity);
                modelAndView.setViewName("index");
            }else if(cancel !=null){
                modelAndView.setViewName("index");
            }
        return modelAndView;
        }

        @RequestMapping("welcome")
              public String welcomePage(){


               return "index";
        }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "welcomeDown",method = RequestMethod.POST)
    public ModelAndView downloadSch(@ModelAttribute("userEntity1") UserEntity userEntity1) throws IOException {
                    downloadSchedule(userEntity1);
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.setViewName("welcome");

                  return modelAndView;
    }


        private void downloadSchedule(UserEntity userEntity) throws IOException {

            String url = "https://students.bsuir.by/api/v1/studentGroup/schedule?studentGroup="+userEntity.getGroupNumber();
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream(),"UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = in.readLine())!= null){
                    sb. append(line);
                }
                JsonFactory f = new JsonFactory();
                JsonParser jp = f.createParser(sb.toString());
                ObjectMapper mapper = new ObjectMapper();
                Example example = mapper.readValue(jp, Example.class);

                //ПОЛЬЗОВАТЕЛЬ
                SheduleEntity sheduleEntity = new SheduleEntity();
                sheduleEntity.setUserByCodeUserId(userEntity);
                sheduleEntity.setValide("true");

                //ГРУППА
                GroupsEntity groupsEntity = new GroupsEntity();
                groupsEntity.setId(example.getStudentGroup().getId());
                groupsEntity.setCalendarId(example.getStudentGroup().getCalendarId());
                groupsEntity.setCourse(example.getStudentGroup().getCourse());
                groupsEntity.setFacultyId(example.getStudentGroup().getFacultyId());
                groupsEntity.setName(example.getStudentGroup().getName());
                groupsEntity.setSpecialityDepartmentEducationFormId(example.getStudentGroup().getSpecialityDepartmentEducationFormId());

                sheduleEntity.setGroupsByCodeGroup(groupsEntity);


                List<Schedule> schedules = example.getSchedules();

                int i =0, dayWeek=1;
                while (i< schedules.size()){
                    // ДЕНЬ НЕДЕЛИ
                DaysweekEntity daysweekEntity = new DaysweekEntity();
                Schedule schedule =  schedules.get(i);
                daysweekEntity.setDayWeek( schedule.getWeekDay());
                daysweekEntity.setId(dayWeek);
                    sheduleEntity.setDaysweekByCodDayWeek(daysweekEntity);


                List<Schedule_> schedule_s=schedule.getSchedule();
                int k=0;
                while(k<schedule_s.size()) {
                    Schedule_ schedule_ = schedule_s.get(k);

                    //ПО КАКИМ НЕДЕЛЯМ
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int r = 0; r < schedule_.getWeekNumber().size(); r++) {
                        stringBuilder.append(schedule_.getWeekNumber().get(r));
                        stringBuilder.append(",");
                    }
                    sheduleEntity.setWeekNumber(stringBuilder.toString());

                    //АУДИТОРИЯ
                    LecturehallEntity lecturehallEntity = new LecturehallEntity();
                    if (schedule_.getAuditory().size() != 0){
                        lecturehallEntity.setHousing(schedule_.getAuditory().get(0));
                    List<LecturehallEntity> lecturehallEntitiess = servise.getListLecture();
                    if (lecturehallEntitiess == null) {
                        servise.addLecture(lecturehallEntity);
                        lecturehallEntity.setId(1);
                    } else {
                        boolean flagg = false;
                        List<LecturehallEntity> lecturehallEntities = servise.getListLecture();
                        for (int u = 0; u < lecturehallEntities.size(); u++) {
                            LecturehallEntity lecturehallEntity1 = lecturehallEntities.get(u);
                            if (lecturehallEntity1.getHousing().equals(lecturehallEntity.getHousing())) {
                                lecturehallEntity.setId(lecturehallEntity1.getId());
                                flagg = true;
                            }
                        }
                        if (flagg == false) {
                            servise.addLecture(lecturehallEntity);
                            lecturehallEntities = servise.getListLecture();
                            for (int u = 0; u < lecturehallEntities.size(); u++) {
                                LecturehallEntity lecturehallEntity1 = lecturehallEntities.get(u);
                                if (lecturehallEntity1.getHousing().equals(lecturehallEntity.getHousing())) {
                                    lecturehallEntity.setId(lecturehallEntity1.getId());
                                    flagg = true;
                                }
                            }
                        }
                    }
                }
                else{
                        boolean flag =false;
                        List<LecturehallEntity> lecturehallEntitiess = servise.getListLecture();
                       for(int t=0;t<lecturehallEntitiess.size();t++){
                           LecturehallEntity lecturehallEntity1 = lecturehallEntitiess.get(t);
                           if(lecturehallEntity1.getHousing().equals(new String("0"))){
                               lecturehallEntity.setId(lecturehallEntity1.getId());
                               flag= true;
                           }}
                           if(flag == false){
                               LecturehallEntity lecturehallEntity2 = new LecturehallEntity();
                               lecturehallEntity2.setHousing(new String("0"));
                               servise.addLecture(lecturehallEntity2);
                               lecturehallEntitiess = servise.getListLecture();
                               for(LecturehallEntity lecturehallEntity3: lecturehallEntitiess){
                                   if (lecturehallEntity3.getHousing().equals(new String("0"))){
                                       lecturehallEntity.setId(lecturehallEntity3.getId());
                                   }
                               }
                       }
                        lecturehallEntity.setHousing("0");

                    }
                    sheduleEntity.setLecturehallByCodeAudience(lecturehallEntity);

                    //ВРЕМЯ
                    CallsEntity callsEntity = new CallsEntity();
                    callsEntity.setStart(schedule_.getStartLessonTime());
                    callsEntity.setEnd(schedule_.getEndLessonTime());

                    List<CallsEntity> callsEntityList2=servise.getListCall();
                    for (int u =0; u <callsEntityList2.size(); u++ ){
                        CallsEntity call=callsEntityList2.get(u);
                        if (callsEntity.getStart().equals(call.getStart())){
                            callsEntity.setId(call.getId());
                        }
                    }

                    sheduleEntity.setCallsByLessonNumber(callsEntity);

                    //ДИСЦИПЛИНА
                    SubjectEntity subjectEntity = new SubjectEntity();
                    subjectEntity.setNameSubject(schedule_.getSubject());
                    subjectEntity.setType(schedule_.getLessonType());

                    List<SubjectEntity> subjectEntities = servise.getListSubject();
                    if(subjectEntities ==null){
                        servise.addSubject(subjectEntity);
                        subjectEntity.setId(1);
                    }
                    else {
                        boolean flagg = false;
                        List<SubjectEntity> subjectEntities1 = servise.getListSubject();
                        for (int u = 0; u < subjectEntities1.size(); u++) {
                            SubjectEntity subjectEntity1 = subjectEntities1.get(u);
                            if (subjectEntity1.getNameSubject().equals(subjectEntity.getNameSubject())) {
                                subjectEntity.setId(subjectEntity1.getId());
                                flagg = true;
                            }
                        }
                        if (flagg == false) {
                            servise.addSubject(subjectEntity);
                            List<SubjectEntity> subjectEntities12 = servise.getListSubject();
                            for (int u = 0; u < subjectEntities12.size(); u++) {
                                SubjectEntity subjectEntity1 = subjectEntities12.get(u);
                                if (subjectEntity1.getNameSubject().equals(subjectEntity.getNameSubject())) {
                                    subjectEntity.setId(subjectEntity1.getId());
                                    flagg = true;
                                }
                            }
                        }
                    }
                    sheduleEntity.setSubjectByCodeDiscipline(subjectEntity);



                    //ПРЕПОДАВАТЕЛЬ
                    TeacherEntity teacherEntity = new TeacherEntity();
                    if(schedule_.getEmployee().size()!=0){
                    teacherEntity.setName(schedule_.getEmployee().get(0).getFirstName());
                    teacherEntity.setSurname(schedule_.getEmployee().get(0).getFirstName());
                    teacherEntity.setPatronymic(schedule_.getEmployee().get(0).getMiddleName());

                    List<TeacherEntity> teacherEntities = servise.getListTeacher();
                    if(teacherEntities ==null){
                        servise.addTeacher(teacherEntity);
                        teacherEntity.setId(1);
                    }
                    else{
                        boolean flagg = false;
                        List<TeacherEntity> teacherEntities1=servise.getListTeacher();
                        for(int u = 0; u<teacherEntities1.size();u++){
                            TeacherEntity teacherEntity1 = teacherEntities1.get(u);
                            if (teacherEntity1.getSurname().equals(teacherEntity.getSurname())&&teacherEntity1.getName().equals(teacherEntity.getName())){
                                teacherEntity.setId(teacherEntity1.getId());
                                flagg =true;
                            }
                        }
                        if (flagg == false){
                            servise.addTeacher(teacherEntity);
                            List<TeacherEntity> teacherEntities12=servise.getListTeacher();
                            for(int u = 0; u<teacherEntities12.size();u++){
                                TeacherEntity teacherEntity1 = teacherEntities12.get(u);
                                if (teacherEntity1.getSurname().equals(teacherEntity.getSurname())&&teacherEntity1.getName().equals(teacherEntity.getName())){
                                    teacherEntity.setId(teacherEntity1.getId());
                                    flagg =true;
                                }
                        }
                    }
                    }}
                    else {
                            boolean flag =false;
                            List<TeacherEntity> teacherEntities = servise.getListTeacher();
                            for(int t=0;t<teacherEntities.size();t++){
                                TeacherEntity teacherEntity1 = teacherEntities.get(t);
                                if(teacherEntity1.getSurname().equals(new String("NULL"))){
                                    teacherEntity.setId(teacherEntity1.getId());
                                    flag= true;
                                }}
                                if(flag == false){
                                    TeacherEntity teacherEntity2 = new TeacherEntity();
                                    teacherEntity2.setName("NULL");
                                    teacherEntity2.setSurname("NULL");
                                    teacherEntity2.setPatronymic("NULL");
                                    servise.addTeacher(teacherEntity2);
                                    teacherEntities = servise.getListTeacher();
                                    for(TeacherEntity teacherEntity3: teacherEntities){
                                        if (teacherEntity3.getSurname().equals(new String("NULL"))){
                                            teacherEntity.setId(teacherEntity3.getId());
                                        }
                                    }
                            }

                    }

                    sheduleEntity.setTeacherByCodeTeacher(teacherEntity);


                    servise.addSchedule(sheduleEntity);

                    k++;
                }
                i++;
                dayWeek++;
                }
            }
        }
}
