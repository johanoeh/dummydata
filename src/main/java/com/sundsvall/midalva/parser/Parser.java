/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sundsvall.midalva.parser;

import java.io.IOException;
import java.util.Optional;

/**
 *
 * @author ohhhhjoh
 */
public interface Parser<T> {
   T parseNext(String line) throws IOException;
}