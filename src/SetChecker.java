/**
 *
 * @author bethan
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetChecker {

    public static boolean isSet(List<?> list) {
        Set<Object> set = new HashSet<>(list);
        return set.size() == list.size();
    }
}
