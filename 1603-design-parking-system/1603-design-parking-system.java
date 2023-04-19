class ParkingSystem {
    int arr[];
    public ParkingSystem(int big, int medium, int small) {
       arr= new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        carType=carType-1;
        if(arr[carType]!=0){
            arr[carType]= arr[carType]-1;
            return true;
        }
        else
            return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */