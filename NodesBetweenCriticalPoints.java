public class NodesBetweenCriticalPoints{
public int[] nodesBetweenCriticalPoints(ListNode head) {

    if (head == null || head.next == null || head.next.next == null)
        return new int[]{-1, -1};

    int minDistance = Integer.MAX_VALUE;
    int index = 2;

    boolean firstCpFound = false;

    int firstCp = 0;
    int previousCp = 0;

    ListNode previousNode = head;
    ListNode currentNode = head.next;

    while (currentNode != null && currentNode.next != null) {

        if ((previousNode.val < currentNode.val &&
             currentNode.val > currentNode.next.val) ||
            (previousNode.val > currentNode.val &&
             currentNode.val < currentNode.next.val)) {

            if (!firstCpFound) {

                firstCpFound = true;
                firstCp = index;

            } else {

                minDistance = Math.min(
                    minDistance,
                    index - previousCp
                );
            }

            previousCp = index;
        }

        previousNode = currentNode;
        currentNode = currentNode.next;
        index++;
    }

    if (!firstCpFound || firstCp == previousCp)
        return new int[]{-1, -1};

    int maxDistance = previousCp - firstCp;

    return new int[]{minDistance, maxDistance};
}
}
