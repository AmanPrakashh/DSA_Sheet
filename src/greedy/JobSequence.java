package greedy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job{
    private int jobId;
    private int deadline;
    private int profit;

    public Job(int jobId, int deadline, int profit)
    {
       this.jobId=jobId;
       this.deadline=deadline;
       this.profit= profit;
    }

    public int getJobId() {
        return jobId;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getProfit() {
        return profit;
    }
}
public class JobSequence {

    public static int [ ] sequenceJob(int [] jobId, int [] deadline, int [] profit){
        List<Job> jobs= new ArrayList<>();
        for(int i=0; i<jobId.length; i++)
        {
            Job job = new Job(jobId[i], deadline[i], profit[i]);
            jobs.add(job);
        }

        Collections.sort(jobs, (a, b)-> a.getDeadline()-b.getDeadline());
        Collections.sort(jobs, (a,b)->a.getProfit()-b.getProfit());
        return null;
    }

    public static void main(String[] args) {
        int [] jobId={};
        int [] deadline={};
        int [] profit={};

        sequenceJob(jobId, deadline, profit);
    }
}
