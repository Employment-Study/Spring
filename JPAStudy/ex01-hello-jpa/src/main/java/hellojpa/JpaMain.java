package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //로딩 시점에 딱 하나만 만들어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //커넥션 객체
        EntityManager em = emf.createEntityManager();
        //jpa가 이루어지는 작업은 모두 transaction이 필요하다.
        EntityTransaction tx = em.getTransaction();
        //Transaction시작
        tx.begin();

        //try-catch-finally로 코드가 정상적으로 마지막까지 수행되게 처리해준다.
        //나중에는 spring이 알아서 해줌
        try{
        //code
//        Member member = new Member();
//         멤버 각 속성 값 입력
//        member.setId(2L);
//        member.setName("HelloB");


            //해당 객체 찾아오기
//            Member member = em.find(Member.class, 1L);
            //해당 객체 출력해보기
//            System.out.println("findMember.id = "+member.getId());
//            System.out.println("findMember.name = "+member.getName());
//
            //멤버 객체를 대상으로 쿼리를 작성한다.
            //m은 멤버의 각 컬럼
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5) //5부터
                    .setMaxResults(8)   //8까지 가져오기
                    .getResultList();

            for (Member member : result){
                System.out.println("member.name =" + member.getName());
            }

//            //해당 객체 삭제
//            em.remove(member);

            //수정
            //JPA가 변경사항을 커밋하는 시점에서 체크해서 바뀐내용이 있으면 Update쿼리를 날려서
//            알아서 변경해준다.
//            member.setName("HelloJPA");


            //저장
//        em.persist(member);

        //Transaction Commit
        tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }

        emf.close();
    }
}
