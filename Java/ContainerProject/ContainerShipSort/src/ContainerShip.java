import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class ContainerShip {
public static void main (String[] args) throws IOException {
    Container obj[] = new Container[7];
//w milimetrach length width height
    obj[0] = new StandardContainer(1, "Standard", "Standard products", 5900, 2350, 2395, 2700, 2000, 4700);
    obj[1] = new HermeticContainer(2, "Hermetic", "Products I.e. medicine, acid", 5900, 2350, 2395, 2900, 1000, 3700);
    obj[2] = new LooseContainer(3, "Loose", "Products I.e. quartz", 5900, 2350, 2395, 2700, 2000, 4700);
    obj[3] = new ElectronicContainer(4, "Electronic", "Electronic products", 5900, 2350, 2395, 2700, 2000, 4700);
    obj[4] = new TankContainer(5, "Tank", "Tank products", 5900, 2350, 2395, 3385, 2000, 4700);
    obj[5] = new PlatformContainer(6, "Platform", "Platform products", 5900, 2350, 2395, 2900, 2000, 4700);
    obj[6] = new ReeferContainer(7, "Reefer", "Reefer products", 5900, 2350, 2395, 2905, 2000, 4700);

    ////// SAVE VALUES IN TXT //////
    try {
        String fileInformation;
        fileInformation = "";
        FileWriter fw = new FileWriter("ListofContainers.txt");

        for (int i = 1; i < 15001; i++) {

            int randInt = new Random().nextInt(obj.length);
            fileInformation = fileInformation + i +"\t" + obj[randInt].containersInfo() + "\n";

        }
        fw.write(fileInformation);
        fw.close();

    } catch (IOException e) {
        System.out.println("There is a problem with code");
        e.printStackTrace();
    }

/////////// GETTING VALUE FROM TXT INTO /////////
    String[] containerList = new String[15000];
    try {
        BufferedReader buf = new BufferedReader(new FileReader("ListofContainers.txt"));

        String lineJustFetched = null;
        int moja = 0;

        while(true){
            lineJustFetched = buf.readLine();
            if(lineJustFetched == null){
                break;
            }else{
                containerList[moja] = lineJustFetched;
                    moja++;
            }
        }
        buf.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    String[][] kontenery = new String[15000][7];
    for(int i = 0;i<15000; i++){
            kontenery[i] = containerList[i].split("\t");
    }

/////SORTOWANIE WZGLEDEM MASY ////
    int n = kontenery.length; //15000
    int j;

    for (int i = 0; i< n; i++) {
        int key = Integer.parseInt(kontenery[i][6].trim());

        String[] keyRow = kontenery[i];
        j = i - 1;
        while ((j >= 0) && (Integer.parseInt(kontenery[j][6].trim()) > key)){

            kontenery[j+1] = kontenery[j];
            j = j-1;
        }
        kontenery[j+1] = keyRow;
        }
    // INFO STATEK
    // LT Cortesia, 334m, 43m, MAX 8100 TEU// 2TEU = 1 kontener ISO
    // https://en.wikipedia.org/wiki/LT_Cortesia
    // 1 kontener ISO = 2 TEU
    // Liczba kontenerow w szerokosci 43000 : 2350 = 18
    //Liczba kontenerow w dlugosci 334000 : 5900 = 56
    // 1008 na jeden poziom + 18 kontenerow na 5 poziom
    // 4050 wszystkich kontenerow
//    int cortesiaLth = 334000;
//    int cortesiaWth = 43000;

int cortesiaCapacity = 8100;
int quantityContainers = cortesiaCapacity/2;

    int konteneryCount = 14999;
    String[][][][] ship = new String[56][18][5][7];

////// Rozkladanie na statku /////////
////// SAVE MANIFEST IN TXT //////
int sumofConteiners = 0;
    FileWriter fw = new FileWriter("ManifestofContainerShip.txt");
    for (int z = 0; z < 5; z++){
        for (int x = 0; x < 56 ;x++){
            for (int y = 0; y < 18; y++) {
                if (konteneryCount >= 0 && sumofConteiners < quantityContainers) {
                        String manifestInformation;

                        manifestInformation = "Location" + "\t" + x + "\t" + y + "\t" + z + "\t" + "Container" + "\t";

                        for (int d = 0; d < 7; d++) {
                            ship[x][y][z][d] = kontenery[konteneryCount][d];
                                manifestInformation = manifestInformation + ship[x][y][z][d] + "\t";

                        }
                        manifestInformation = manifestInformation + "\n";
                        fw.write(manifestInformation);
                        sumofConteiners++;
                        konteneryCount--;
                }
            }
    }
            }
    fw.close();

        }
    }

class Container {
    private int id;
    private String name;
    private String product;
    private int length;
    private int width;
    private int height;
    private int containerMass;
    private int productMass;
    private int allMass;
    public Container(int id, String name, String product, int length, int width, int height, int containerMass, int productMass, int allMass){
        this.id = id;
        this.name = name;
        this.product = product;
        this.length = length;
        this.width = width;
        this.height = height;
        this.containerMass = containerMass;
        this.productMass = productMass;
        this.allMass = containerMass + productMass;
    }

    public String containersInfo() {
        String[] allProducts;
        int[] allProductMasses;
        int randInt;
        int randMass;

        switch(name) {
            case "Standard":
                allProducts = new String[]{"clothes", "furniture", "toys", "wood", "metal"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                containerMass = 2700;
                allMass = containerMass + productMass;
                break;

            case "Hermetic":
                containerMass = 2700;
                allProducts = new String[]{"blood", "medicine", "acid", "bananas"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                allMass = containerMass + productMass;
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                break;

            case "Loose":
                containerMass = 2350;
                allProducts = new String[]{"quartz", "magnetite", "silver"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                allMass = containerMass + productMass;
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                break;

            case "Electronic":
                containerMass = 3385;
                allProducts = new String[]{"computers", "microchips", "laptops", "keyboards"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                allMass = containerMass + productMass;
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                break;

            case "Tank":
                containerMass = 3385;
                allProducts = new String[]{"gas", "biofuel", "fuel", "ethanol"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                allMass = containerMass + productMass;
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                break;
            case "Platform":
                containerMass = 2385;
                allProducts = new String[]{"tractor", "van", "car", "truck", "semitrailer"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                allMass = containerMass + productMass;
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                break;

            case "Reefer":
                containerMass = 2885;
                allProducts = new String[]{"bananas", "ice-creams", "fuel", "meat", "seafood"};
                allProductMasses = new int[]{1500, 2110, 1800, 2400, 4200, 1330, 665, 3200, 3410, 2300};
                randMass = new Random().nextInt(allProductMasses.length);
                productMass = allProductMasses[randMass];
                allMass = containerMass + productMass;
                randInt = new Random().nextInt(allProducts.length);
                product = allProducts[randInt];
                break;

        }
        return name + "\t" + product  +  "\t" + length+ "\t" + width+ "\t" + height+ "\t" + allMass;
    }

}

class StandardContainer extends Container {
        public StandardContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass) {
            super(id, name, product, length, width, height, containerMass, productMass, allMass);

        }

}

class HermeticContainer extends Container {

        public HermeticContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass){
            super(id, name, product, length, width, height, containerMass, productMass, allMass);

        }
    }
class LooseContainer extends Container {
    public LooseContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass){
        super(id, name, product, length, width, height, containerMass, productMass, allMass);

    }
}

class ElectronicContainer extends Container {
    public ElectronicContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass) {
        super(id, name, product, length, width, height, containerMass, productMass, allMass);

    }
}

class TankContainer extends Container {
    public TankContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass) {
        super(id, name, product, length, width, height, containerMass, productMass, allMass);

    }
}

class PlatformContainer extends Container {
    public PlatformContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass){
        super(id, name, product, length, width, height, containerMass, productMass, allMass);


    }
}

class ReeferContainer extends Container {
    public ReeferContainer(int id, String name, String product,int length, int width, int height, int containerMass,int productMass, int allMass) {
        super(id, name, product, length, width, height, containerMass, productMass, allMass);

    }
}
