import { Component, OnInit } from '@angular/core';
import { ApprovalServiceService } from '../Services/approval-service.service';

@Component({
  selector: 'app-training-progress',
  templateUrl: './training-progress.component.html',
  styleUrls: ['./training-progress.component.css']
})
export class TrainingProgressComponent implements OnInit {

  constructor(private approvalService: ApprovalServiceService) { }
  trainees: any;
  trainee: any;
  state: boolean = false;
  pstate: boolean = false;
  empty: boolean = false;
  pempty: boolean = false;
  ngOnInit() {
  }

  paynow(traineeId: number) {

    this.approvalService.payNow(traineeId).subscribe(
      (data) => {
        this.pending();
        alert(" Request Accepted !! ");
      }
    );

  }

  completed() {
    this.state = true;
    this.pstate = false;
    this.approvalService.getAllCompletedTraineeList().subscribe(
      (data) => {
        console.log(data);
        this.trainee = data;
        if (this.trainee == null)
          this.empty = false;
        else
          this.empty = true;
      }
    );
  }

  pending() {
    this.pstate = true;
    this.state = false;
    this.approvalService.getAllInprogressTraineeList().subscribe(
      (data) => {
        console.log(data);
        this.trainees = data;
        if (this.trainees == null)
          this.pempty = false;
        else
          this.pempty = true;
      }
    );
  }
}

