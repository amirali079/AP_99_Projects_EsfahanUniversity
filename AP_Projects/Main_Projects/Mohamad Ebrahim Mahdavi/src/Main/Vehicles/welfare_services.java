package Main.Vehicles;

public enum welfare_services {
        restaurant(200),wc(100),game_center(150),cooling_system(75),cafe(125),pool(175),cleaning_service(50),city_tour(50);
        double price;
        welfare_services(double price) {
            this.price = price;
        }
        public double get_price()
        {
            return price;
        }
}
