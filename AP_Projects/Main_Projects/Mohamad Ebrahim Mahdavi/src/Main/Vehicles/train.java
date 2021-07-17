package Main.Vehicles;

public class train extends land_vehicle{
    protected int wagon_num;
    protected int star;
    public train(String id, String company_name, String production_date,int wagon_num,int star) {
        super(id, company_name, 300, 300, 200, 1500, 7500, production_date);
        this.star=star;
        this.wagon_num=wagon_num;
    }
    @Override
    public void basic_info()
    {
        System.out.println("The information of your train :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nWelfare service :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.price+"$");
    }
    @Override
    public void full_info()
    {
        System.out.println("The total information of your train :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nprice : "+super.price+"\ncapacity : "+super.capacity+"\nmax speed : "+super.max_speed+"\npower : "+super.power+"\nfuel capacity : "+super.fuel_capacity+"\nservices : cooling system"+"\nwagon num : "+wagon_num+"\nstars : "+star);
    }
    protected void finalize()
    {
        System.out.println("The train has been sold!\nYour money will return with 50% reduction");
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
