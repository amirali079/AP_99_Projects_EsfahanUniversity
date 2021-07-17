package Main.Vehicles;

public class cargo_plane extends air_vehicle{
    protected double max_weight;
    public cargo_plane(String id, String company_name, String production_date, double max_weight) {
        super(id, company_name, 200, 300, 11000, 2000, 1000, production_date);
        this.max_weight=max_weight;
    }
    @Override
    public void basic_info()
    {
        System.out.println("The information of your cargo plane :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date);
    }
    @Override
    public void full_info()
    {
        System.out.println("The total information of your cargo plane :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nprice : "+super.price+"\ncapacity : "+super.capacity+"\nmax altitude : "+super.max_altitude+"\nmin runway : "+super.min_runway+"\nmax speed : "+super.max_speed+"\nmax weight : "+max_weight);
    }
    protected void finalize()
    {
        System.out.println("The airliner has been sold!\nYour money will return with 50% reduction");
    }
    public double get_price()
    {
        return super.price;
    }
    public String get_id()
    {
        return super.id;
    }
}
