package com.choa.ex2;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject	//Data type으로 찾는다
	private NoticeService noticeService;
	
	//NoticeList
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public void noticeList(Model model, @RequestParam(defaultValue="1") Integer curPage)throws Exception{
		List<NoticeDTO> ar = noticeService.noticeList(curPage);
		model.addAttribute("list", ar);
	}
	
	//NoticeView
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public void noticeView(Integer num, Model model)throws Exception{
		if(num==null){
			num = 1;
		}
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
	}
	
	//NoticeWriteForm writeForm
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public void noticeWrite()throws Exception{
		
	}
	
	//NoticeWrite
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, RedirectAttributes rd)throws Exception{
		int result = noticeService.noticeWrite(noticeDTO);
		String message="FAIL";
		if(result==1){
			message="success";
		}
		
		rd.addFlashAttribute("message", message);		//RedirectAttributes Redirect방식
		//model.addAttribute("message", message);			//Model은 foward방식
		 
		return "redirect:/notice/noticeList";
		//return "notice/result";
		//return "redirect:/noticeList?curPage=2";		파라미터를 주고싶다면 여기서
	}
	
	//NoticeUpdateForm
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public void noticeUpdate(Model model, int num)throws Exception{
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
	}
	
	//NoticeUpdate
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd)throws Exception{
		int result = noticeService.noticeUpdate(noticeDTO);
		String message="FAIL";
		if(result==1){
			message="success";
		}
		
		rd.addFlashAttribute("message", message);		//RedirectAttributes Redirect방식
		//model.addAttribute("message", message);			//Model은 foward방식
		 
		return "redirect:/notice/noticeList";
		//return "notice/result";
		//return "redirect:/noticeList?curPage=2";		파라미터를 주고싶다면 여기서
	}
	
	//NoticeDelete
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public void noticeDelete(Integer num)throws Exception{
		int result = noticeService.noticeDelete(num);
		if(result==1){
			
		}else{
			
		}
		
	}
}
