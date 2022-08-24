package gs;

import java.util.*;

public class MaxAverageStudent {

    public static void main(String ...args){
        List<List<Object>> students = new ArrayList<>();
        students.add(Arrays.asList("Bob", 80));
        students.add(Arrays.asList("Charles", 85));
        students.add(Arrays.asList("Rob", 70));
        students.add(Arrays.asList("Bob", 100));
        students.add(Arrays.asList("Bob", 80));
        students.add(Arrays.asList("Charles", 75));
        getMaximumAverageScore(students);
    }

    public static float getMaximumAverageScore(List<List<Object>> students){
        if(students == null || students.isEmpty()){
            return 0;
        }
        final Map<String, Integer> scoreMap = new HashMap<>();
        final Map<String, Integer> studentCountMap = new HashMap<>();
        students.forEach(student -> {
            String studentName = ((String)student.get(0)).toLowerCase();
            if(scoreMap.containsKey(studentName)){
                scoreMap.put(studentName, scoreMap.get(studentName)+(Integer)student.get(1));
                studentCountMap.put(studentName,studentCountMap.get(studentName)+1);
            }else{
                scoreMap.put(studentName, (Integer)student.get(1));
                studentCountMap.put(studentName,1);
            }
        });
        float maxAverage = Float.MIN_VALUE;
        String maxAvgStudentName = null;
        for(String student : scoreMap.keySet()){
            float avg = (float)scoreMap.get(student)/studentCountMap.get(student);
            if(avg > maxAverage){
                maxAverage = avg;
                maxAvgStudentName = student;
            }
        }
        System.out.println("Max Average for "+maxAvgStudentName+" : "+maxAverage);
        return maxAverage;
    }
}
