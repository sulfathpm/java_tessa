public class cpu{
    int price;
    class processor{
        int no_of_cores;
        String manufacturer;
        processor(int no_of_cores,String manufacturer){
            this.no_of_cores=no_of_cores;
            this.manufacturer=manufacturer;
        }
        void display(){
            System.out.println("No. of cores: "+no_of_cores+" \nManufacturer : "+manufacturer);
        }
    }
    static class ram{
        int memory;
        String manufacturer;
        public ram(int memory,String manufacturer){
            this.memory=memory;
            this.manufacturer=manufacturer;
        }
        display(){
            System.out.println("Memory : "+memory+" Manufacturer : "+manufacturer);
        }
    }
}


public class computer {
    public static void main(String[] args) {
        cpu c=new cpu();
        cpu.processor p=c.new processor("3","abc");
        p.display();
        cpu.ram r=c.new ram("8","abc");
        r.display();
    }
}
