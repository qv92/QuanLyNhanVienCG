import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QLNV {
    static ArrayList<NhanVien> list = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);
    public static int nhapTuoiNhanVien() {
        System.out.print("Nhập tuổi nhân viên: ");
        int tuoi = Integer.parseInt(sc.nextLine());
        if (tuoi < 18) throw new InputMismatchException("tuổi không được nhỏ hơn 18");
        return tuoi;
    }
    public static String nhapEmail(){
        System.out.println("Nhập email nhân viên");
        String email= sc.nextLine();
        for (NhanVien NhanVien:list) {
            if (NhanVien.getEmail().equals(email)) throw new InputMismatchException("Email đã tồn tại");
        }
        return email;
    }
    public static double nhapLuong(){
        System.out.println("Nhập lương");
        double luong=Double.parseDouble(sc.nextLine());
        return luong;
    }
    public static String nhapGioiTinh() {
            System.out.println("Nhập giới tính");
            String gioi_tinh = sc.nextLine();
            if((!gioi_tinh.equals("nam")) || (!gioi_tinh.equals("nu")))
                throw new InputMismatchException("Giới tính phải là nam hoặc nu");
            return gioi_tinh;
        }
    public static void addNhanVienPartTime(){
        System.out.println("Nhập tên");
        String ten = sc.nextLine();
        while (true){
            try{ int tuoi=nhapTuoiNhanVien();break;}
            catch (InputMismatchException e){
                System.out.println("nhap lai");
            }
            catch (Exception e){
                System.out.println("tuoi phai lon hon 18 va la so");
            }
        }
        while (true){
            try{
                String gioi_tinh=nhapGioiTinh();break;
            }
            catch (InputMismatchException e){
                e.getMessage();
            }
        }
        System.out.println("Nhập số điện thoại");
        String sdt=sc.nextLine();
        while (true){
            try{
                String email = nhapEmail();break;
            }
            catch (InputMismatchException e){
                System.out.println("Nhập lại email mới , email đã tồn tại ");
            }
        }
        while (true){
            try{
                double luong=nhapLuong();break;
            }
            catch (Exception e){
                System.out.println("Lương phải là 1 số");
            }
        }
        System.out.println("Nhập ngành");
        String nganh=sc.nextLine();
        System.out.println("Nhập giờ làm việc");
        double gio_lam_viec = Double.parseDouble(sc.nextLine());
        NhanVien nhanVien = new NhanVienPartTime( ten, nhapTuoiNhanVien(),  nhapGioiTinh(),  sdt,  nhapEmail(),  nhapLuong(),  nganh,  gio_lam_viec);
        list.add(nhanVien);
    }
    public static void addNhanVienFullTime(){
        System.out.println("Nhập tên");
        String ten = sc.nextLine();
        while (true){
            try{ int tuoi=nhapTuoiNhanVien();break;}
            catch (InputMismatchException e){
                System.out.println("Tuổi phải là số và lớn hơn 18");
            }
            catch (Exception e){
                System.out.println("Tuổi phải là số và lớn hơn 18");
            }
        }
        while (true){
            try{
                String gioi_tinh=nhapGioiTinh();break;
            }
            catch (InputMismatchException e){
                e.getMessage();
            }
        }
        System.out.println("Nhập số điện thoại");
        String sdt=sc.nextLine();
        while (true){
            try{
                String email = nhapEmail();break;
            }
            catch (InputMismatchException e){
                System.out.println("Nhập lại email mới , email đã tồn tại ");
            }
        }
        while (true){
            try{
                double luong=nhapLuong();break;
            }
            catch (Exception e){
                System.out.println("Lương phải là 1 số");
            }
        }
        System.out.println("Nhập ngành");
        String nganh=sc.nextLine();
        NhanVien nhanVien = new NhanVienFullTime( ten,  nhapTuoiNhanVien(),  nhapGioiTinh(),  sdt,  nhapEmail(),  nhapLuong(),  nganh);
        list.add(nhanVien);
    }
    public static void addNhanVienTuyenSinh(){
        System.out.println("Nhập tên");
        String ten = sc.nextLine();
        while (true){
            try{ int tuoi=nhapTuoiNhanVien();break;}
            catch (InputMismatchException e){
                System.out.println("nhap lai");
            }
            catch (Exception e){
                System.out.println("tuoi phai lon hon 18 va la so");
            }
        }
        int tuoi=nhapTuoiNhanVien();
        while (true){
            try{
                String gioi_tinh=nhapGioiTinh();break;
            }
            catch (InputMismatchException e){
                e.getMessage();
            }
        }
        System.out.println("Nhập số điện thoại");
        String sdt=sc.nextLine();
        while (true){
            try{
                String email = nhapEmail();break;
            }
            catch (InputMismatchException e){
                System.out.println("Nhập lại email mới , email đã tồn tại ");
            }
        }
        while (true){
            try{
                double luong=nhapLuong();break;
            }
            catch (Exception e){
                System.out.println("Lương phải là 1 số");
            }
        }
        System.out.println("Nhập số tuyển sinh");
        int so_tuyen_sinh = Integer.parseInt(sc.nextLine());
        NhanVien nhanVien = new NhanVienTuyenSinh( ten,  tuoi,  nhapGioiTinh(),  sdt,  nhapEmail(),  nhapLuong(),  so_tuyen_sinh);
        list.add(nhanVien);
    }
    public static void addNhanVienDaoTao(){
        while (true){
            System.out.println("1.Thêm nhân viên full time");
            System.out.println("2.Thêm nhân viên parttime");
            System.out.println("3.Thoát");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addNhanVienFullTime();
                    break;
                case 2:
                    addNhanVienPartTime();
                    break;
                case 3:
                    break;
            }if (choice==3) break;
        }
    }
    public static void addNhanVien(){
        while (true){
            System.out.println("1.Thêm nhân viên đào tạo");
            System.out.println("2.Thêm nhân viên tuyển sinh");
            System.out.println("3.Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addNhanVienDaoTao();
                    break;
                case 2:
                    addNhanVienTuyenSinh();
                    break;
                case 3:
                    break;
            }if (choice==3) break;
        }
    }
    public static void removeNhanVienDaotao(){
        System.out.println("Nhập tên cần đuổi");
        String nameRemove=sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(nameRemove)&&list.get(i).toString().contains("NhanVienDaoTao")){
                list.remove(i);
                i--;
            }
        }
    }
    public static void removeNhanVienTuyenSinh(){
        System.out.println("Nhập tên cần đuổi");
        String nameRemove=sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(nameRemove)&&list.get(i).toString().contains("NhanVienTuyenSinh")){
                list.remove(i);
                i--;
            }
        }
    }
    public static void showDoanhThu(){
        System.out.println("Nhập tên");
        String nameDoanhThu=sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(nameDoanhThu)){
                System.out.println("Doanh thu của " + nameDoanhThu+" là "+ list.get(i).doanh_thu());
            }
        }
    }
    public static void findNhanVienByName(){
        System.out.println("Nhập tên nhân viên cần tìm");
        String nameFind=sc.nextLine();
        for (NhanVien nhanvien:list) {
            if (nhanvien.getTen().equals(nameFind)){
                System.out.println(nhanvien);
            }
        }
    }
    public static void sortByName(){
        list.sort(Comparator.comparing(o->((NhanVien)o).getTen()));
    }
    public static void sortByDoanhThu(){
        list.sort(Comparator.comparing(o->((NhanVien)o).doanh_thu()));
    }
    public static void showNhanVien(){
        for (NhanVien nhanvien:list) {
            System.out.println(nhanvien);
        }
    }
    public static void removeNhanVien(){
        while (true){System.out.println("1.Xóa nhân viên đào tạo");
        System.out.println("2.Xóa nhân viên tuyển sinh");
        System.out.println("3.Thoát");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                removeNhanVienDaotao();
                break;
            case 2:
                removeNhanVienTuyenSinh();
                break;
            case 3:
                break;
        }if (choice==3) break;
    }}
    public static void menu(){
        while (true){
            System.out.println("1.Thêm nhân viên");
            System.out.println("2.Đuổi nhân viên");
            System.out.println("3.Hiển thị doanh thu nhân viên");
            System.out.println("4.Tìm kiếm nhân viên");
            System.out.println("5.Sắp xếp nhân viên theo tên");
            System.out.println("6.Sắp xếp nhân viên theo doanh thu");
            System.out.println("7.Hiển thị toàn bộ nhân viên");
            System.out.println("8.Thoát");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addNhanVien();
                    break;
                case 2:
                    removeNhanVien();
                    break;
                case 3:
                    showDoanhThu();
                    break;
                case 4:
                    findNhanVienByName();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    sortByDoanhThu();
                    break;
                case 7:
                    showNhanVien();
                    break;
                case 8:
                    break;
            }
        }
    }

}

