# analizador_lexico.py

import ply.lex as lex

tokens = ['NUM', 'PLUS', 'TIMES']

# Definición de Tokens
t_PLUS = r'\+'
t_TIMES = r'\*'
t_NUM = r'\d+'

t_ignore = ' \t\n'

# Definición de error léxico
def t_error(t):
    print(f"Error léxico: {t.value[0]}")
    t.lexer.skip(1)

lexer = lex.lex()

def analizar(texto):
    lexer.input(texto)
    return [tok for tok in lexer]
