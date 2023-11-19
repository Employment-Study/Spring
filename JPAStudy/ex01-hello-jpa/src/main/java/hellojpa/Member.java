package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //필수로 들어가는 어노테이션, 객체로 인식하게 하기 위함
//@Table(name = "USER") //USEr라는 테이블로 나가게 지정
public class Member {

    @Id //id에 Pk값을 주기 위해 적용하는 어노테이션
    private Long id;
//    @Column(name = "username") //username이라는 DB컬럼과 맵핑시키기
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
