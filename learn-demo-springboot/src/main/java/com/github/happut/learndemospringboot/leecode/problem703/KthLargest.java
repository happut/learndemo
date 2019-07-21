package com.github.happut.learndemospringboot.leecode.problem703;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> q;

    int k;
    
    public KthLargest(int k, int[] nums) {

        this.k = k;
        q = new PriorityQueue<>(k);
        for(int n : nums){
            q.add(n);
        }
        
    }
    
    public int add(int val) {
        if(q.size()<k){
            q.offer(val);
        }

        else if(q.peek()<val){
            q.poll();
            q.offer(val);

        }
        return q.peek();
    }


    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(obj.add(3));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */