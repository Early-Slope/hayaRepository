package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

	@RequestMapping(value = "/1000S", method = RequestMethod.GET)
    public String index0() {
        return "1000S";
    }

	@RequestMapping(value = "/1001S", method = RequestMethod.GET)
    public String index1() {
        return "1001S";
    }

	@RequestMapping(value = "/1002S", method = RequestMethod.GET)
    public String index2() {
        return "1002S";
    }

	@RequestMapping(value = "/1010S", method = RequestMethod.GET)
    public String index3() {
        return "1010S";
    }

	@RequestMapping(value = "/1020S", method = RequestMethod.GET)
    public String index4() {
        return "1020S";
    }

	@RequestMapping(value = "/1021S", method = RequestMethod.GET)
    public String index5() {
        return "1021S";
    }

	@RequestMapping(value = "/1030S", method = RequestMethod.GET)
    public String index6() {
        return "1030S";
    }

	@RequestMapping(value = "/1040S", method = RequestMethod.GET)
    public String index7() {
        return "1040S";
    }

	@RequestMapping(value = "/1050S", method = RequestMethod.GET)
    public String index8() {
        return "1050S";
    }

	@RequestMapping(value = "/1060S", method = RequestMethod.GET)
    public String index9() {
        return "1060S";
    }

	@RequestMapping(value = "/2040S", method = RequestMethod.GET)
    public String index10() {
        return "2040S";
    }

/*
	@RequestMapping(value = "/1000S", method = RequestMethod.GET)
    public ModelAndView index0(ModelAndView mav) {
		mav.setViewName("1000S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1001S", method = RequestMethod.GET)
    public ModelAndView index1(ModelAndView mav) {
		mav.setViewName("1001S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1002S", method = RequestMethod.GET)
    public ModelAndView index2(ModelAndView mav) {
		mav.setViewName("1002S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1010S", method = RequestMethod.GET)
    public ModelAndView index3(ModelAndView mav) {
		mav.setViewName("1010S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1020S", method = RequestMethod.GET)
    public ModelAndView index4(ModelAndView mav) {
		mav.setViewName("1020S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1021S", method = RequestMethod.GET)
    public ModelAndView index5(ModelAndView mav) {
		mav.setViewName("1021S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1030S", method = RequestMethod.GET)
    public ModelAndView index6(ModelAndView mav) {
		mav.setViewName("1030S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1040S", method = RequestMethod.GET)
    public ModelAndView index7(ModelAndView mav) {
		mav.setViewName("1040S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1050S", method = RequestMethod.GET)
    public ModelAndView index8(ModelAndView mav) {
		mav.setViewName("1050S");
		System.out.println(mav);
        return mav;
    }

	@RequestMapping(value = "/1060S", method = RequestMethod.GET)
    public ModelAndView index9(ModelAndView mav) {
		mav.setViewName("1060S");
		System.out.println(mav);
        return mav;
    }

*/

}


