class OrderedStream {
    List<String> chunk;
    int ptr;
    public OrderedStream(int n) {
        chunk = new ArrayList<>(n);
        ptr=0;
        for(int i=0;i<n;i++){
            chunk.add("");
        }
    }
    
    public List<String> insert(int idKey, String value) {
        chunk.set(idKey-1, value);
        int start=ptr;

        while(ptr<chunk.size() && !chunk.get(ptr).equals("")){
            ptr+=1;
        }

        return new ArrayList<>(chunk.subList(start, ptr));
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */