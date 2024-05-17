
class screeningTest {
    class Laptop {
        //code here
        public int price;
        public String details;

        Laptop(int price, String details) {
            this.price = price;
            this.details = details;
        }
    }

    class Afford {
        //code here

        public String checkConfiguration(Laptop laptop) throws Exception, LaptopException {

            String[] details = laptop.details.split("/");

            if (laptop.price > 7000) throw new LaptopException("Price too high");
            else if (Integer.parseInt(details[0]) < 8) throw new LaptopException("Minimum 8 RAM");
            else if (Integer.parseInt(details[1]) < 8) throw new LaptopException("Minimum 256 space required");
            else if (details[2].equals("HDD")) throw new LaptopException("HardDisk type is HDD");

            return "Can be purchased";
        }

        public String purchseLaptop(Laptop laptop) {
            try {
                checkConfiguration(laptop);
            } catch (LaptopException e) {
                return "Change configuration";
            } catch (Exception ex) {
                return "other exception";
            }
            return "Prefect configuration";
        }


    }

    class LaptopException extends Throwable {
        public LaptopException(String msg) throws Exception {
            throw new Exception(msg);
        }
    }
}
