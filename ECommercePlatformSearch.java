import java.util.*;
class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}
class search {
    public Product binarySearch(Product products[], String tofind) {
        Arrays.sort(products,Comparator.comparing(p -> p.productName.toLowerCase()));
        int low = 0;
        int high = products.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            int cmp = products[mid].productName.compareToIgnoreCase(tofind);
            if(cmp==0)  return products[mid];
            else if(cmp>0) high = mid - 1;
            else low = mid + 1;
        }
        return null;
    }
    public Product linearSearch(Product products[], String tofind) {
        for(Product pro : products) {
            if(pro.productName().compareToIgnoreCase(tofind)==0)
                return pro;
        }
        return null;
    }
}
public class  {
    public static void main(String[] args) throws Exception {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        Product products[] = new Product[n];
        for(int i=0;i<n;i++) {
            products[i].productId = S.nextInt();
            products[i].productName = S.next();
            products[i].category = S.next();
        }
        String tofind = S.next();
        Product res = search.linearSearch(products, tofind);
        System.out.println("Linear Search Result : " + (res==null?"Not found":res));
        Product res = search.binarySearch(products, tofind);
        System.out.println("Binary Search Result : " + (res==null?"Not found":res));
    }
}
