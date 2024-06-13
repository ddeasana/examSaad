package controllers;

import model.Note;
import model.NoteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notes")
public class NoteController extends HttpServlet {
    private NoteRepository noteRepository = new NoteRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            listNotes(req, resp);
        } else if (pathInfo.equals("/add")) {
            showAddForm(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String context = req.getParameter("context");

        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContext(context);

        noteRepository.addNote(newNote);
        resp.sendRedirect("index.jsp");
    }

    private void listNotes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Note> notes = noteRepository.getAllNotes();
        req.setAttribute("notes", notes);
        req.getRequestDispatcher("listNotes.jsp").forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addNote.jsp").forward(req, resp);
    }

}