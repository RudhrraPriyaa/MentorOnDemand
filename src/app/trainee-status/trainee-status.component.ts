import { Component, OnInit } from '@angular/core';
import { ApprovalServiceService } from '../Services/approval-service.service';
import { AuthServiceService } from '../Services/auth-service.service';
import { training } from '../Model/Training';

@Component({
  selector: 'app-trainee-status',
  templateUrl: './trainee-status.component.html',
  styleUrls: ['./trainee-status.component.css']
})
export class TraineeStatusComponent implements OnInit {

  //trainees:training[]
  trainee: any;
  trainees: any;
  traineess: training[];
  empty: boolean = false;
  pempty: boolean = false;
  state: boolean = false;
  pstate: boolean = false;


  constructor(private approvalService: ApprovalServiceService, private authService: AuthServiceService) { }

  ngOnInit() {
  }
  accept(traineeId: number) {

    this.approvalService.giveApproval(traineeId).subscribe(
      (data) => {
        alert("done");
        this.pending();
      }
    );

  }
  completedd() {
    this.pstate = true;
    this.state = false;
    this.approvalService.getAllCompletedMentorList().subscribe(
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

  pending() {
    this.state = true;
    this.pstate = false;
    this.approvalService.getAllInprogressMentorList().subscribe(
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

  decline(traineeId: number) {
    this.approvalService.declineApproval(traineeId).subscribe((data) => {
      this.pending();
      alert('Request deleted successfully!!!');
    })
  }
  redirecting() {
    this.approvalService.statusList(this.authService.username).subscribe(
      data => {
        console.log(data);
        this.trainee = data
      }
    )
  }

  completed(traineeId: number) {

    this.approvalService.completed(traineeId).subscribe(
      (data) => {
        this.pending();
        alert(" Request Accepted !! ");
      }
    );

  }




}


