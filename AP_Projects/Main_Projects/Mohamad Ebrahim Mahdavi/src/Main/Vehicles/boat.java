package Main.Vehicles;

public class boat extends sea_vehicle{
    protected double max_weight=800;
    protected String material;

    public boat(String id, String company_name, String production_date, String material) {
        super(id, company_name, 75, 10, "gasoline", 2, 70, 15, production_date);
        this.material = material;
    }
    public double get_price()
    {
        return super.price;
    }

    @Override
    public void basic_info()
    {
        System.out.println("The information of your bus :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date);
    }

    @Override
    public void full_info()
    {
        System.out.println("The total information of your bus :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nprice : "+super.price+"\ncapacity : "+super.capacity+"\nmax speed : "+super.max_speed+"\nfuel capacity : "+super.fuel_capacity+"\nfuel type : "+fuel_type+"\nmin depth : "+min_depth+"\nmaterial : "+material);
    }
    protected void finalize()
    {
        System.out.println("The boat has been sold!\nYour money will return with 50% reduction");
    }
    public String get_id()
    {
        return super.id;
    }
}
