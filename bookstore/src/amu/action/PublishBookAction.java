package amu.action;

import amu.Mailer;
import amu.model.Customer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class PublishBookAction implements Action {

    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
            actionResponse.addParameter("from", "customerSupport");
            return actionResponse;
        }

       // if (request.getMethod().equals("POST")) {
         //   Mailer.send(request.getParameter("bookTitle"), 
           //         request.getParameter("authors"), 
           //         request.getParameter("publisher"), 
           //         request.getParameter("publishedTime"), 
           //         request.getParameter("edition"),
           //         request.getParameter("isbn"), 
           //         request.getParameter("price"),
           //         request.getParameter("fromAddr"), 
           //         request.getParameter("fromName"));
            // TODO: Send receipt to customer
      //      return new ActionResponse(ActionResponseType.REDIRECT, "publishBookSuccessful");
      //  } 

        return new ActionResponse(ActionResponseType.FORWARD, "customerSupport");
    }
}
