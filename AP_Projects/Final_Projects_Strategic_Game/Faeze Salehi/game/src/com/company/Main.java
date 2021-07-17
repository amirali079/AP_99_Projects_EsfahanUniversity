package com.company;

import javax.swing.*;
import java.io.IOException;

public class Main
{
    static Background b;
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                b = new Background();
            }
            catch (IOException ignored) {}
        });
    }
}
