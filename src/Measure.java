public abstract class Measure {


    public String measurement;

    public void setUpper(){
        measurement = measurement.toUpperCase();
    }

    public abstract String getMeasurement();

    public abstract void setMeasurement(String measurement);
}
