package Main.Vehicles;

public class bus extends land_vehicle{
    public bus(String id, String company_name, String production_date) {
        super(id, company_name, 100, 30, 110, 120, 300, production_date);
        ws.add(welfare_services.cooling_system);
    }
    @Override
    public void basic_info()
    {
        System.out.println("The information of your bus :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date);
    }
    @Override
    public void full_info()
    {
        System.out.println("The total information of your bus :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nprice : "+super.price+"\ncapacity : "+super.capacity+"\nmax speed : "+super.max_speed+"\npower : "+super.power+"\nfuel capacity : "+super.fuel_capacity+"services : cooling system");
    }
    protected void finalize()
    {
        System.out.println("The bus has been sold!\nYour money will return with 50% reduction");
    }
    public double get_price()
    {
        return (super.price+Vehicle.get_service_price("cooling_system"));
    }
    public String get_id()
    {
        return super.id;
    }

}
