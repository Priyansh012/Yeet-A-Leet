class Solution {
    public double[] convertTemperature(double celsius) {
      double kelvin,fahrenheit;
      double ans[]= new double[2];
      kelvin =celsius+273.15;
      ans[0]=kelvin;
      fahrenheit=(celsius*1.80)+32.00;
      ans[1]=fahrenheit;
      return ans;
    }
}