import com.Service.Team_Service;
import com.dto.TeamDTO;
import com.persisterce.Team_UserEntity;
import com.repository.Team_userReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
@Component
public class test {
    @Autowired
    Team_userReository team_userReository;
    @Autowired
    Team_Service team_service;
    @Test
    public void test(){
        int dto = team_service.getTotalItem();
    }
}
