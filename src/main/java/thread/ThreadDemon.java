package thread;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.entity.*;
import servise.Servise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ThreadDemon extends Thread{

    Servise servise;

    public ThreadDemon(Servise servise) {
        this.servise = servise;
    }

    @Override
    public void run(){
        /* Обновить список групп*/
       // updateGroup();


while (true) {
    try {
        List<UserEntity> userEntities = servise.getListUser();
        for (UserEntity userEntity : userEntities){
            //*****************
            // ПРОВЕРКА ОБНОВЛЕНИЯ РАССПИСАНИЯ ДЛЯ ВСЕХ ПОЛЬЗОВАТЕЛЕЙ
            //*****************
            String url = "https://students.bsuir.by/api/v1/studentGroup/schedule?studentGroup="+userEntity.getGroupNumber();

        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.connect();
        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            JsonFactory f = new JsonFactory();
            JsonParser jp = f.createParser(sb.toString());
            ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
            Example example = mapper.readValue(jp, Example.class);

            List<SheduleEntity> sheduleEntities= servise.getListShedule();

                    List<Schedule> schedules =example.getSchedules();
                    for(int i=0;i<schedules.size();i++){
                      Schedule schedule= schedules.get(i);
                      List<Schedule_> schedule_s = schedule.getSchedule();
                      String dayweek= schedule.getWeekDay();

                        for(int j =0; j<schedule_s.size();j++){
                            Schedule_ schedule_ = schedule_s.get(j);
                            String timeStart = schedule_.getStartLessonTime();
                            String subjectName = schedule_.getSubject();
                            boolean flag = false;
                            for(SheduleEntity sheduleEntity: sheduleEntities){
                                if(sheduleEntity.getUserByCodeUserId().getId() == userEntity.getId()){
                                    if(sheduleEntity.getDaysweekByCodDayWeek().getDayWeek().equals(dayweek)){
                                    CallsEntity callsEntity = sheduleEntity.getCallsByLessonNumber();
                                    SubjectEntity subjectEntity = sheduleEntity.getSubjectByCodeDiscipline();
                                    if(timeStart.equals(callsEntity.getStart())&&subjectName.equals(subjectEntity.getNameSubject())){
                                        flag= true;
                                    }
                                    }
                                }
                            }
                            if(flag == false) {
                                userEntity.setValid("false");
                                servise.updateUser(userEntity);
                            }
                        }
                    }


        } else {
            System.out.println("fail" + connection.getResponseCode());
        }
    }
        sleep(1800000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    catch (Throwable cause) {
        cause.printStackTrace();
    }
}
    }



    private void updateGroup(){
        String url = "https://students.bsuir.by/api/v1/groups";
        HttpURLConnection connection = null;
        try{
            connection= (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.connect();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = in.readLine())!= null){
                    sb. append(line);
                }
                String str = sb.toString();
                JsonFactory f = new JsonFactory();
                JsonParser jp = f.createParser(str);
                jp.nextToken();
                ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
                while (jp.nextToken() == JsonToken.START_OBJECT) {
                    GroupsEntity groupsEntity = mapper.readValue(jp, GroupsEntity.class);
                    if(groupsEntity.getCourse()==null) groupsEntity.setCourse(0);
                    if(groupsEntity.getCalendarId() == null) groupsEntity.setCalendarId("ERROR");
                    servise.addGroup(groupsEntity);
                }
            }
            else {
                System.out.println("fail"+ connection.getResponseCode());
            }
        }
        catch (Throwable cause){

        }
        finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }
}
