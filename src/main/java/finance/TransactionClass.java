package finance;

import javax.persistence.*;

@Entity
@Table(name="transactions")
public class TransactionClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String AccNo;

    @Column
    private String Amount;

    public TransactionClass() { }

//    public Student(int id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccNo() {
        return AccNo;
    }
    public void setAccNo(String AccNo) {
        this.AccNo = AccNo;
    }
    public void setAmount(String Amount) {
        this.Amount = Amount;
    }
    public String getAmount() {
        return this.Amount;
    }

}
