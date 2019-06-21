package package1.start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import package1.start.dao.RegisterLLDao;
import package1.start.model.Appointment;
import package1.start.model.Doctor;
import package1.start.model.Drug;
import package1.start.model.Fpdoct;
import package1.start.model.OnlineActiveMode;
import package1.start.model.PersonalAssist;
import package1.start.model.StudPsSms;
import package1.start.model.Student;

@Service
@Transactional
public class RegisterLLServiceImpl  implements  RegisterLLService {

	@Autowired
private RegisterLLDao dao;
	@Override
	@Transactional
	public void studentreg(Student st) {
		
		dao.studentreg(st);
	}

	@Override
	@Transactional
	public void doctorreg(Doctor dr,PersonalAssist ps) {
		ps.setName("psof"+dr.getName());
		dr.setPs(ps);ps.setDtr(dr);
		dao.doctorreg(dr, ps);
	}

	@Override
	@Transactional
	public void studentupdate(Student st) {
		
		dao.studentupdate(st);
	}

	@Override
	@Transactional
	public void doctorupdate(Doctor dr) {
	
		dao.doctorupdate(dr);
	}

	@Override
	public String verifyloginstudent(String uname, String password) {
	
return dao.verifyloginstudent(uname, password);
	}

	@Override
	public String verifylogindoctor(String uname, String password) {
	
		return dao.verifylogindoctor(uname, password);
	}

	@Override
	public String checkuniquestudent(String name, String password) {
	
		return dao.checkuniquestudent(name, password);
	}

	@Override
	public String checkuniquedoctor(String name, String password) {
		
		return dao.checkuniquedoctor(name, password);
	}

	@Override
	public List<Doctor> getalldoctor() {
		List<Doctor> drs = dao.getalldoctor();
  	        return drs;	
				        }

	@Override
	public void addspsmsg(StudPsSms sps,String sender) {
		dao.addspsmsg(sps,sender);
		
	}

	@Override
	public Student searchstudent(String name) {
		// TODO Auto-generated method stub
		return dao.searchstudent(name);
	}

	@Override
	public String invalidSIDwhilesms(String password,int sid) {
		// TODO Auto-generated method stub
		return dao.invalidSIDwhilesms(password,sid);
	}

	@Override
	public int getStudId(String password) {
		// TODO Auto-generated method stub
		return dao.getStudId(password);
	}

	@Override
	public int getDocId(String password) {
		// TODO Auto-generated method stub
		return dao.getDocId(password);
	}

	@Override
	public void addphotodr(String path,String filename, int did) {
		dao.addphotodr(path,filename, did);
		
	}

	@Override
	public void addactive_status(OnlineActiveMode oam) {
	dao.addactive_status(oam);
		
	}

	@Override
	public List<OnlineActiveMode> activelistofdoctor() {
		
		return dao.activelistofdoctor();
	}

	@Override
	public ModelMap listofknockedpatient(int did) {
	
		return dao.listofknockedpatient(did);
	}

	@Override
	public Doctor getdoctorbyid(int did) {
		// TODO Auto-generated method stub
		return dao.getdoctorbyid(did) ;
	}

	@Override
	public Student getpatientbyid(int sid) {
		// TODO Auto-generated method stub
		return dao.getpatientbyid(sid);
	}

	@Override
	public void adddpress(Fpdoct p, List<Drug> lst) {
	
		dao.adddpress(p, lst);
	}

	@Override
	public String existPrescriptionOrNot(int did, int sid) {

		return dao.existPrescriptionOrNot(did, sid);
	}

	@Override
	public List<Fpdoct> searchpatient(int pid) {
		
		return dao.searchpatient(pid);
	}

	@Override
	public List<Fpdoct> listofprescribedpatient(int did) {
		
		return dao.listofprescribedpatient(did);
	}

	@Override
	public Appointment reqappointment(Appointment app) {
		
		return dao.reqappointment(app);
	}

	@Override
	public List<Appointment> appreqlist(int did) {
		
		return dao.appreqlist(did);
	}

	@Override
	public void confirmappointment(int app_id,String meet_date) {
		
		dao.confirmappointment(app_id, meet_date);
	}

	@Override
	public List<Appointment> appletter(int sid) {
		// TODO Auto-generated method stub
		return dao.appletter(sid);
	}

	@Override
	public String createuniquepres() {
		// TODO Auto-generated method stub
		return dao.createuniquepres();
	}

	@Override
	public List<Drug> provideddrugs(int drug_id) {
		// TODO Auto-generated method stub
		return dao.provideddrugs(drug_id);
	}

	

}
