import java.util.*;

public class Demo {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result  = new ArrayList<>();
            if(candidates == null) {
                return result;
            }

            Arrays.sort(candidates);
            List<Integer> list = new ArrayList<>();

            Deque<Integer> deque = new LinkedList<>();


            helper(result, list, candidates, target, 0);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int pos) {
            // 1. 递归什么时候退出
            // 2. 单一集合什么时候可以加到解集里面
            if(list.stream().reduce(Integer::sum).isPresent() && target == list.stream().reduce(Integer::sum).get()) {
                result.add(new ArrayList<>(list));
                return;
            }
            // 3. 拆分问题规模，使用递归
            for(int i = pos; i < candidates.length; i++) {
                // 4. 完善单一解，递归解决
                list.add(candidates[i]);
                helper(result, list, candidates, target, i);
                // 5. 回溯
                list.remove(list.size() - 1);
            }
        }



}
