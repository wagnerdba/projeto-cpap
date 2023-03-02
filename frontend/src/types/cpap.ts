export type Cpap = {
    id: number;
    data: string;
    eventos_hora: number;
    horas_uso: string;
    pontuacao: string;
    col_ret_masc: number;
}

export type CpapPage = {
    content?: Cpap[];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
}

export type CpapSum = {
    data: string;
    eventos_hora: number;
}

export type CpapEvents = {
    data: string;
    eventos_hora: number;
}