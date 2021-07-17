package Main.Vehicles;

public class ship extends sea_vehicle{
    protected double max_weight=300000;
    protected String material;

    public ship(String id, String company_name, String production_date, String material) {
        super(id, company_name, 600, 3000, "LSFO", 50, 40, 3000000, production_date);
        this.material = material;
    }
    public double get_price()
    {
        return super.price;
    }

    @Override
    public void basic_info()
    {
        System.out.println("The information of your ship :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nWelfare service :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.price+"$");
    }

    @Override
    public void full_info()
    {
        System.out.println("The total information of your ship :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nprice : "+super.price+"\ncapacity : "+super.capacity+"\nmax speed : "+super.max_speed+"\nfuel capacity : "+super.fuel_capacity+"\nfuel type : "+fuel_type+"\nmin depth : "+min_depth+"\nmaterial : "+material);
    }
    protected void finalize()
    {
        System.out.println("The ship has been sold!\nYour money will return with 50% reduction");
    }

    public String get_id()
    {
        return super.id;
    }
}
