package main;

public class Limits {
    int limitPrime;
    int limitPro;
    int limitVpn;
    int limitPass;
    int limitOptim;
    int limitSpeed;

    public Limits (){
        limitPrime = 10;
        limitPro = 10;
        limitVpn = 10;
        limitPass = 10;
        limitOptim = 10;
        limitSpeed = 10;
    }

    public void setLimits(int a, int b, int c, int d, int e, int f) {
        limitPrime = a;
        limitPro = b;
        limitVpn = c;
        limitPass = d;
        limitOptim = e;
        limitSpeed = f;
    }
}
