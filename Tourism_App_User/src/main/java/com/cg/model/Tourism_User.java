package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Tourism Application DataBase")

public class Tourism_User {
    //Attributes
		@Id  // primary key
		private int userid;
		private String destination;
		private String recommended_place;
		private int total_Cost;
		public Tourism_User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Tourism_User(int adminid, String destination, String recommended_place, int total_Cost) {
			super();
			this.userid = adminid;
			this.destination = destination;
			this.recommended_place = recommended_place;
			this.total_Cost = total_Cost;
		}
		public int getAdminid() {
			return userid;
		}
		public void setAdminid(int adminid) {
			this.userid = adminid;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getRecommended_place() {
			return recommended_place;
		}
		public void setRecommended_place(String recommended_place) {
			this.recommended_place = recommended_place;
		}
		public int getTotal_Cost() {
			return total_Cost;
		}
		public void setTotal_Cost(int total_Cost) {
			this.total_Cost = total_Cost;
		}
		@Override
		public String toString() {
			return "Tourism_User [adminid=" + userid + ", destination=" + destination + ", recommended_place="
					+ recommended_place + ", total_Cost=" + total_Cost + "]";
		}
}
	
