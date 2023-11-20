package ManagementPersistent;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// JPA가 관리하는 엔티티
//필수로 들어가는 어노테이션, 객체로 인식하게 하기 위함
// 기본 생서자 필수(파라미터가 없는 public 또는 protected생성자), Proxy, Reflection등을 적용하기 위함
//final 클래스, enum , inteface, inner 클래스 사용 X
// 저장할 필드에 final 사용 X
//@Table(name = "USER")
@Entity(name="Member")

//같은 클래스 이름이 없으면 기본값사용 같은 클래스가 있으면 직접 이렇게 지정

    @TableGenerator(
            name = "MEMBER_SEQ_GENERATOR",
            table = "MY_SEQUENCES",
            pkColumnValue = "MEMBER_SEQ", allocationSize = 50) // 미리 50개를 만들어놓고 nextVal이 51번째가 되면 다시 50개를 더 만들어준다. 0~50 >> 51~ 100
// USER 이라는 테이블로 나가게 지정, 스키마, 카탈로그등도 지정이 가능하다. 유니크 제약조건도 넣을 수 있음
public class Member {

//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.AUTO) //각 DB (오라클,mySQL) 등의 방언에 맞게 생성
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 DB가 알아서 해준다.
    @SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="member_seq" )
    @Id
    private Long id;


            //Column 의 속성
            /*
                1. name : 필드의 이름은 테이블의 컬럼 이름과 맞아야 한다.
                2. ijnsertable, updateable : 해당 컬럼을 반영할지 말지 결정하는 속성, false로 해두면 DB에 반영되지 않는다.
                3. Nullable(DDL) : 기본값 true, false 일경우 not null 제약 조건이 걸린다.
                4. unique(DDL) : true로 제약조건을 걸 수 있지만 잘 사용하지 않는다.  만들어주긴 하지만 이름이 랜덤으로 생성되기 떄문에 잘 사용하지 않음
                                    운영에서는 해당 이름을 보고 바로 알아야 하는데 알아 볼 수 없다.
                                    그래서 @Table(uniqueConstraints = "")에서 unique를 걸어줄 수 있다.
                5. columnDefinition : 컬럼에 대한 정보를 직접 줄 수 있다. 예시 : varchar2(100) default 'Empty'
                6. length : 문자 길이 제약조건, String타입만

            //Transient
                메모리상에서만 임시로 어떤 값을 보관하고 싶을 떄 사용한다.
             */
            @Column(name = "name")
            private String username;

//    private Integer age;
//
//    //Enum타입을 쓸 떄 default타입은 Ordinal이다. Ordianl 은 enum의 순서를 저장 String은 이름을 DB에 저장
//    // String으로 하지 않으면 Enum에 새로운 값을 넣으면 순서가 꼬여서 문제가 생긴다.
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    //과거버전을 쓰는경우 3타입중 하나에 알맞게 지정해주고 사용하면 된다.
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;
//
//    //어노테이션이 없어도 타입을 아니까 알아서 생성해준다.
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;

//    public Member() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }


            // 기본 키 맵핑에서 id를  String으로 변경
            public Member(){
            }

            public Long getId(){
            return id;
            }

            public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
