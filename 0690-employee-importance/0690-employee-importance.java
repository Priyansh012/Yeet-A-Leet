
// class Employee {
//     public int id;
//     public int importance;
//     public List<Integer> subordinates;
// }

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(employeeMap.get(id));

        int totalImportance = 0;

        while (!queue.isEmpty()) {
            Employee emp = queue.poll();
            totalImportance += emp.importance;

            for (Integer subId : emp.subordinates) {
                if (employeeMap.containsKey(subId)) {
                    queue.offer(employeeMap.get(subId));
                }
            }
        }

        return totalImportance;
    }
}
