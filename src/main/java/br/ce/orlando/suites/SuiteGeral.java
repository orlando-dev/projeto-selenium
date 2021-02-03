package br.ce.orlando.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.orlando.tests.ContaTest;
import br.ce.orlando.tests.MovimentacaoTest;
import br.ce.orlando.tests.RemoverMovimentacaoContaTest;
import br.ce.orlando.tests.ResumoTest;
import br.ce.orlando.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ 
		ContaTest.class, 
		MovimentacaoTest.class, 
		RemoverMovimentacaoContaTest.class, 
		SaldoTest.class,
		ResumoTest.class })
public class SuiteGeral {
	
}
