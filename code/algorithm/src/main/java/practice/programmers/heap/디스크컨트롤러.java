package practice.programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러
{
    public static class Job {
        public int startTime;
        public int amount;

        public Job(int startTime, int amount) {
            this.startTime = startTime;
            this.amount = amount;
        }
    }

    public int solution(int[][] jobs) {
        Job[] arrJobs = new Job[jobs.length];
        for (int i=0; i<arrJobs.length; i++) {
            int[] job = jobs[i];
            arrJobs[i] = new Job(job[0], job[1]);
        }

        Arrays.sort(arrJobs, new Comparator<Job>() {

            @Override
            public int compare(Job o1, Job o2) {
                return o1.startTime - o2.startTime;
            }
        });

        PriorityQueue<Job> pqJobs = new PriorityQueue<>(new Comparator<Job>() {

            @Override
            public int compare(Job o1, Job o2) {
                return o1.amount - o2.amount;
            }
        });

        int jobsIdx = 0;
        int time = 0;
        int waitingSum = 0;
        outerLoop: while (true) {
            Job job = arrJobs[jobsIdx];
            while (time >= job.startTime) {
                pqJobs.add(job);
                jobsIdx++;
                if (jobsIdx >= arrJobs.length) {
                    break outerLoop;
                }

                job = arrJobs[jobsIdx];
            }

            if (!pqJobs.isEmpty()) {
                job = pqJobs.remove();
                time += job.amount;
                waitingSum += time - job.startTime;
            } else {
                time = job.startTime;
            }
        }

        while (!pqJobs.isEmpty()) {
            Job job = pqJobs.remove();
            time += job.amount;
            waitingSum += time - job.startTime;
        }

        return waitingSum / arrJobs.length;
    }
}
