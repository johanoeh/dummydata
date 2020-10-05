/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import java.io.IOException;

/**
 *
 * @author ohhhhjoh
 */
public interface Parser {
   public String nextName() throws IOException;    
}
