package package1.start.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import package1.start.model.Doctor;
import package1.start.model.Drug;
import package1.start.model.Fpdoct;
import package1.start.service.RegisterLLService;

@Controller
public class SearchController {
	  @Autowired 
	    private RegisterLLService srvc2;
	
	@RequestMapping(value="/search")
public ModelAndView searchpatient(@RequestParam("pid") int pid) {
	List<Fpdoct> plist = srvc2.searchpatient(pid);

	return new ModelAndView("searchpatientrecord","fpform",plist);
	
}
	
	@RequestMapping(value="/getdocbyid/{did}")
public ModelAndView docbyid(@PathVariable("did") int did) {
	Doctor dr = srvc2.getdoctorbyid(did);

	return new ModelAndView("searchpatientrecord","doc",dr);
	
}
	
	@RequestMapping(value="/provideddrug/{fpid}")
public ModelAndView provideddrug(@PathVariable("fpid") int fpid) {
	List<Drug> lst = srvc2.provideddrugs(fpid);
for(Drug d : lst) {
	
	System.out.println("drug name is "+d.getNdrug()+"    "+"schedule of drug"+"  "+d.getSdrug());
	System.out.println("patient name is"+d.getFpdoct().getXpname());
}
	return new ModelAndView("provideddrugs","druglist",lst);
	
}
	
	
	
	@RequestMapping(value="/presfordoc/{sid}/{aid}", method=RequestMethod.GET)
	public ModelAndView presfordoc(@PathVariable("sid") int sid,@PathVariable("aid") int aid,
			
			HttpServletResponse rs) throws IOException {
		ModelAndView mv = new ModelAndView("successtodownload");
		mv.addObject("sms", "downloaded prescription successfully");
			String existprescription = srvc2.existPrescriptionOrNot(aid, sid);
		if(existprescription.equals("not")) {
			mv.setViewName("meetonline");
	mv.addObject("failmsg","your doctor have not prescribe any thing yet!! request him to provide a prescription");
	     }else {
			File file = new File(existprescription);
			FileInputStream k = new FileInputStream(file);
			InputStream im = new  BufferedInputStream(k );
			String mimetype = URLConnection.guessContentTypeFromStream(im);
			if(mimetype==null) {
			mimetype="application/octet-stream";
			rs.setContentType(mimetype);
			rs.setContentLengthLong(file.length());
			rs.setHeader("Content-Disposition", String.format("attachment;filename=\"%s\"",file.getName()));
			FileCopyUtils.copy(im,rs.getOutputStream());
	}	
}
		
		return mv;
}
}