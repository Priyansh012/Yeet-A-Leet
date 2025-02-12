
// class Employee {
//     public int id;
//     public int importance;
//     public List<Integer> subordinates;
// }

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //adjacency list
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }

        //BFS
        Queue<Employee> queue = new LinkedList<>();
        //only traversing from that particular node instead of traversing all the nodes because its not a tree but a graph
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
