public class Vital extends CondimentDecarator {

    private Measure measure;

    public Vital(Measure measure) {
        this.measure = measure;
    }

    @Override
    public String getMeasurement() {
        if(measure.getMeasurement() != null)
        return Integer.parseInt(measure.getMeasurement()) + Integer.parseInt(this.measurement) +"";
        return Integer.parseInt(measure.getMeasurement())+"";
    }

    @Override
    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}
