package com.dsa.striver30daysSheet.d8_GreedyAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {
    static class Job {
        int id, profit, deadline;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static class JobComparator implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.deadline < b.deadline) {
                return -1;
            } else if (a.deadline > b.deadline) {
                return 1;
            } else if (a.profit > b.profit) {
                return -1;
            } else if (a.profit < b.profit) {
                return 1;
            }
            return 1;
        }
    }

    static {
        System.out.println("Please Provide Input");
    }

    public static void main(String[] args) throws IOException {
        int n = 5;
        Job[] arr = new Job[n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            arr[i] = new Job(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));

        }

        System.out.println(Arrays.toString(new JobSequencingProblem().JobScheduling(arr, n)));
    }

    public int[] JobScheduling(Job[] arr, int n) {
//        Arrays.sort(arr, new JobComparator());
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxDeadline = 0;

        for (Job a : arr) {
            maxDeadline = Math.max(maxDeadline, a.deadline);
        }

        int[] result = new int[maxDeadline + 1];
        for (int i = 1; i <= maxDeadline; i++) {
            result[i] = -1;
        }
        int countJobs = 0, jobProfit = 0;
        for (int i = 0; i < n; i++) {

            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, jobProfit};
    }
}

// tc

//1 4 20
//2 1 10
//3 1 40
//4 1 30

//1 2 100
//2 1 19
//3 2 27
//4 1 25
//5 1 15