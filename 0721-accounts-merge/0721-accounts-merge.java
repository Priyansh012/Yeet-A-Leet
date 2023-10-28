class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node))
            return node;
        int ultimateParent=findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ultimateParentU= findParent(u);
        int ultimateParentV= findParent(v);

        if(ultimateParentU == ultimateParentV)
            return;
        
        if(size.get(ultimateParentU) < size.get(ultimateParentV)){
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentU)+size.get(ultimateParentV));
        }
        else{
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU)+size.get(ultimateParentV));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mailNodeMap = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(mailNodeMap.containsKey(mail)==false){
                    mailNodeMap.put(mail, i);
                }
                else{
                    ds.unionBySize(i,mailNodeMap.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail= new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String, Integer> it : mailNodeMap.entrySet()){
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0)
                continue;
            
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String it: mergedMail[i])
                temp.add(it);
            
            ans.add(temp);

        }

        return ans;
    }
}