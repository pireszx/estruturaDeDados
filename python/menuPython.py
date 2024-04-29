class Atleta:
    def __init__(self, fone, nome, apelido, dataNascimento, pontuacaoAcumulada):
        self.fone = fone
        self.nome = nome
        self.apelido = apelido
        self.dataNascimento = dataNascimento
        self.pontuacaoAcumulada = pontuacaoAcumulada

    def __str__(self):
        return f"Nome: {self.nome}, Apelido: {self.apelido}, Data de Nascimento: {self.dataNascimento}, Pontuação Acumulada: {self.pontuacaoAcumulada}"

    def __eq__(self, other):
        return self.fone == other.fone

    def __hash__(self):
        return hash(self.fone)


class Menu:
    def __init__(self):
        self.atletas = []

    def listar_atletas(self):
        if not self.atletas:
            print("Nenhum atleta cadastrado.")
            return
        for atleta in self.atletas:
            print(atleta)

    def cadastrar_atleta(self, atleta):
        if atleta in self.atletas:
            print("Atleta já cadastrado.")
        else:
            self.atletas.append(atleta)
            print("Atleta cadastrado com sucesso.")

    def procurar_atleta(self, chave):
        for atleta in self.atletas:
            if chave.lower() in (atleta.nome.lower(), atleta.apelido.lower()):
                print(atleta)
                return
        print("Atleta não encontrado.")

    def remover_atleta(self, chave):
        for atleta in self.atletas:
            if chave.lower() in (atleta.nome.lower(), atleta.apelido.lower()):
                self.atletas.remove(atleta)
                print("Atleta removido")
                return
        print("No encontrado")


def main():
    menu = Menu()

    while True:
        print("1 - Listar atletas")
        print("2 - Cadastrar atleta")
        print("3 - Procurar por atleta")
        print("4 - Remover atleta")
        print("5 - Sair")
        print("Opção:")
        opcao = input()

        if opcao == "1":
            sistema.listar_atletas()
        elif opcao == "2":
            fone = input("Digite o telefone: ")
            nome = input("Digite o nome: ")
            apelido = input("Digite o apelido: ")
            data_nascimento = input("Digite a data de nascimento: ")
            pontuacao_acumulada = input("Digite a pontuação: ")
            atleta = Atleta(fone, nome, apelido, data_nascimento, pontuacao_acumulada)
            sistema.cadastrar_atleta(atleta)
        elif opcao == "3":
            chave = input("Procure o atleta por nome ou apelido: ")
            sistema.procurar_atleta(chave)
        elif opcao == "4":
            chave = input("Remova o atleta por nome ou apelido: ")
            sistema.remover_atleta(chave)
        elif opcao == "5":
            print("Você saiu!!!")
            break
        else:
            print("ERRO!!!")


if __name__ == "__main__":
    main()
