public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    /** construter function with six parameters */
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    /** construter with a Planet parameter */
    public Planet(Planet p){
        this(p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
    }

    /** compute the distance between this planet with the given planet */
    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
    }

    /** compute the force this planet exerte to given planet */
    public double calcForceExertedBy(Planet p){
        double d = calcDistance(p);
        return (G * p.mass * this.mass)/(d * d);
    }

    /** compute the force this planet exert to given planet on x direction */
    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    /** compute the force this planet exert to given planet on y direction */
    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    /** compute the netForce exerted by the given planet array on x direction */
    public double calcNetForceExertedByX(Planet[] p){
        double res = 0;
        for(Planet pl:p){
            if(!this.equals(pl)){
                res += calcForceExertedByX(pl);
            }
        }
        return res;
    }

    /** compute the netForce exerted by the given planet array on y direction */
    public double calcNetForceExertedByY(Planet[] p){
        double res = 0;
        for(Planet pl:p){
            if(!this.equals(pl)){
                res += calcForceExertedByY(pl);
            }
        }
        return res;
    }

    /** update the position with given force and time */
    public void update(double dt,double fX,double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + aX * dt;
        this.yyVel = this.yyVel + aY * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
