package collections;

import collections.nodelist.NodeList;
import org.assertj.core.util.DateUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeListTest {
    private NodeList<String> nodeList;

    @BeforeMethod
    void precondition() {
        nodeList = new NodeList<>();
    }


    @Test(description = "Empty list should have zero size")
    void zeroSize() {
        assertThat(nodeList.size())
                .isEqualTo(0);
    }

    @Test(description = "List should contain new element after adding")
    void addElement() {
        final int listSize = nodeList.size();
        String expectedVal = addRandElement();

        assertThat(nodeList.size())
                .isEqualTo(listSize + 1);
        assertThat(nodeList.asSting())
                .contains(expectedVal);
    }

    @Test(description = "List should not contain new element after removing")
    void removeElement() {
        final String val = addRandElement();
        final int listSize = nodeList.size();
        nodeList.remove(val);

        assertThat(nodeList.size())
                .isEqualTo(listSize - 1);
        assertThat(nodeList.asSting())
                .doesNotContain(val);
    }

    private String addRandElement() {
        final String val = DateUtil.now().toString();
        this.nodeList.add(val);
        return val;
    }
}
