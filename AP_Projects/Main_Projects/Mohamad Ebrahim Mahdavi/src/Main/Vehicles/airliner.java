package Main.Vehicles;

public class airliner extends air_vehicle{
    protected int staff_num;
    protected String classes;

    public airliner(String id, String company_name, String production_date, int staff_num, String classes) {
        super(id, company_name, 250, 4, 11000, 2000, 1000, production_date);
        this.staff_num = staff_num;
        this.classes = classes;
    }
    @Override
    public void basic_info()
    {
        System.out.println("The information of your airliner :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nThe welfare services :");
        for (welfare_services ws1:ws)
            System.out.println(ws1.name()+" "+ws1.price+"$");
    }
    @Override
    public void full_info()
    {
        System.out.println("The total information of your airliner :\nid : "+super.id+"\ncompany : "+super.company_name+"\nproduction date : "+super.production_date+"\nprice : "+super.price+"\ncapacity : "+super.capacity+"\nmax altitude : "+super.max_altitude+"\nmin runway : "+super.min_runway+"\nmax speed : "+super.max_speed+"\nstaff num : "+staff_num+"\nclasses : "+classes);
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
